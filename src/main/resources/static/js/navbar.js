function scrollToFooter() {
    const footer = document.getElementById('footer-contato');
    footer.scrollIntoView({ behavior: 'smooth' });
}
document.addEventListener("DOMContentLoaded", () => {
    const toggleButton = document.getElementById("navbar-toggle-button");
    const navList = document.getElementById("navbarSupportedContent4");
    const links = document.querySelectorAll("a");

    console.log("hey ho lets go")

    toggleButton.addEventListener("click", () => {
        navList.classList.toggle("hidden");
    });

    links.forEach(link => {
        if (link.href === "http://localhost:8080/") {
            link.classList.add("font-bold", "opacity-100");
        }
    })
});