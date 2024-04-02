const canvas = document.getElementById('rippleCanvas');
const ctx = canvas.getContext('2d');

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

let ripples = [];

function createRipple(x, y, radius, color) {
  return { x, y, radius, color, maxRadius: Math.random() * 50 + 50 }; // Augmentation de la taille maximale de l'onde
}

function drawRipple(ripple) {
  ctx.beginPath();
  ctx.arc(ripple.x, ripple.y, ripple.radius, 0, Math.PI * 2);
  ctx.strokeStyle = ripple.color;
  ctx.lineWidth = 2;
  ctx.stroke();
}

function animate() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  for (let i = 0; i < ripples.length; i++) {
    ripples[i].radius += 2;
    drawRipple(ripples[i]);

    if (ripples[i].radius > ripples[i].maxRadius) {
      ripples.splice(i, 1);
      i--;
    }
  }

  requestAnimationFrame(animate);
}

document.addEventListener('keydown', function (event) {
  if (event.code === 'Space') {
    const x = Math.random() * canvas.width;
    const y = Math.random() * canvas.height;
    const radius = Math.random() * 10 + 5;
    const color = `hsl(${Math.random() * 360}, 100%, 50%)`;

    ripples.push(createRipple(x, y, radius, color));
  }
});

animate();
