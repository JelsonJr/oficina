document.addEventListener("DOMContentLoaded", function () {
    const toggleButton = document.getElementById("navbar-toggle-button");
    const navList = document.getElementById("navbarSupportedContent4");
    const links = document.querySelectorAll("a");

    toggleButton.addEventListener("click", () => {
        navList.classList.toggle("hidden");
    });

    links.forEach(link => {
        if(link.href === "http://localhost:8080/") {
            link.classList.add("text-white", "opacity-100");
        }
    })
});
