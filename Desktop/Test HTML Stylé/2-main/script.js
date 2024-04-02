document.addEventListener("DOMContentLoaded", function () {
  const container = document.querySelector(".container");
  const explosionContainer = document.querySelector(".explosion");

  function createExplosion(x, y) {
      const explosion = document.createElement("div");
      explosion.className = "explosion";
      container.appendChild(explosion);

      explosion.style.left = x + "px";
      explosion.style.top = y + "px";

      anime({
          targets: explosion,
          width: 200,
          height: 200,
          opacity: 0,
          easing: "easeOutQuad",
          duration: 800,
          complete: () => container.removeChild(explosion)
      });
  }

  function handleMouseClick(event) {
      const x = event.clientX;
      const y = event.clientY;
      createExplosion(x, y);
  }

  container.addEventListener("click", handleMouseClick);
});

