const API_BASE_URL = 'http://localhost:8080'; // Adjust to your backend URL

// Fetch all feedback
async function getAllFeedback() {
    try {
        const response = await fetch(`${API_BASE_URL}/feedback`);
        const feedback = await response.json();
        displayFeedback(feedback);
    } catch (error) {
        console.error('Error fetching feedback:', error);
    }
}

// Filter feedback by user
async function filterByUser() {
    const userId = document.getElementById('filterUserId').value;
    if (!userId) {
        alert('Please enter a User ID');
        return;
    }
    try {
        const response = await fetch(`${API_BASE_URL}/feedback/user/${userId}`);
        const feedback = await response.json();
        displayFeedback(feedback);
    } catch (error) {
        console.error('Error fetching user feedback:', error);
    }
}

// Filter feedback by book
async function filterByBook() {
    const bookId = document.getElementById('filterBookId').value;
    if (!bookId) {
        alert('Please enter a Book ID');
        return;
    }
    try {
        const response = await fetch(`${API_BASE_URL}/feedback/book/${bookId}`);
        const feedback = await response.json();
        displayFeedback(feedback);
    } catch (error) {
        console.error('Error fetching book feedback:', error);
    }
}

// Submit new feedback
async function submitFeedback() {
    const userId = document.getElementById('userId').value;
    const bookId = document.getElementById('bookId').value;
    const rating = document.getElementById('rating').value;
    const message = document.getElementById('message').value;

    if (!userId || !bookId || !rating || !message) {
        alert('Please fill all fields');
        return;
    }

    const feedback = {
        feedbackId: 0, // Will be set by backend
        feedbackUser: { userId: parseInt(userId) },
        rating: parseInt(rating),
        book: { bookId: parseInt(bookId) },
        message
    };

    try {
        const response = await fetch(`${API_BASE_URL}/feedback`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(feedback)
        });
        if (response.ok) {
            alert('Feedback submitted successfully');
            document.getElementById('userId').value = '';
            document.getElementById('bookId').value = '';
            document.getElementById('rating').value = '';
            document.getElementById('message').value = '';
            getAllFeedback();
        } else {
            alert('Error submitting feedback');
        }
    } catch (error) {
        console.error('Error submitting feedback:', error);
    }
}

// Display feedback list
function displayFeedback(feedback) {
    const feedbackList = document.getElementById('feedbackList');
    feedbackList.innerHTML = '';
    feedback.forEach(f => {
        const div = document.createElement('div');
        div.className = 'bg-white p-4 rounded-lg shadow-md';
        div.innerHTML = `
            <p><strong>Feedback ID:</strong> ${f.feedbackId}</p>
            <p><strong>User ID:</strong> ${f.feedbackUser.userId}</p>
            <p><strong>Book ID:</strong> ${f.book.bookId}</p>
            <p><strong>Rating:</strong> ${f.rating}</p>
            <p><strong>Message:</strong> ${f.message}</p>
        `;
        feedbackList.appendChild(div);
    });
}

// Initial load
getAllFeedback();