document.addEventListener('DOMContentLoaded', () => {
    // Get references to the HTML elements
    const loginForm = document.getElementById('loginForm');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const messageDisplay = document.getElementById('message');

    // Add an event listener to the form for when it's submitted
    loginForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent the default form submission (which would reload the page)

        // Get the values entered by the user
        const username = usernameInput.value;
        const password = passwordInput.value;

        // Prepare the data to be sent as JSON
        const loginData = {
            username: username,
            password: password
        };

        // Define the backend API endpoint URL
        // IMPORTANT: Ensure this matches the port your Spring Boot app is running on (default: 8080)
        const apiUrl = 'http://localhost:8080/api/login';

        try {
            // Send the login data to the backend using the Fetch API
            const response = await fetch(apiUrl, {
                method: 'POST', // We are sending data, so it's a POST request
                headers: {
                    'Content-Type': 'application/json', // Tell the server we are sending JSON
                    'Accept': 'application/json' // Tell the server we prefer JSON in response
                },
                body: JSON.stringify(loginData) // Convert JavaScript object to JSON string
            });

            // Parse the response from the server as text
            const resultMessage = await response.text();

            // Handle the response based on its status code
            if (response.ok) { // response.ok is true for 2xx status codes (e.g., 200 OK)
                displayMessage(resultMessage, 'success');
            } else { // For other status codes (e.g., 401 Unauthorized)
                displayMessage(resultMessage, 'error');
            }

        } catch (error) {
            // Catch any network errors or issues with the fetch request
            console.error('Error during login:', error);
            displayMessage('An error occurred. Please try again later.', 'error');
        }
    });

    // Function to display messages to the user
    function displayMessage(msg, type) {
        messageDisplay.textContent = msg; // Set the text content
        messageDisplay.className = 'message ' + type; // Apply CSS class for styling (success/error)
    }
});