package org.example.ui

object MenuRenderer {
    fun showMainMenu(): Int {
        println(
            """
            -----------------------------
            GitHub User Information Menu
            -----------------------------
            1. Retrieve user information based on username
            2. Display the list of users in memory
            3. Search by username among users in memory
            4. Search by repository name among data in memory
            5. Exit the program
            """.trimIndent()
        )
        print("Enter your choice (1-5): ")
        return readlnOrNull()?.toIntOrNull() ?: -1
    }
}
