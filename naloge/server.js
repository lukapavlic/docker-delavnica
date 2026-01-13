const http = require("http");

const PORT = process.env.PORT || 3000;

const server = http.createServer((req, res) => {
  const clientIp =
    req.socket.remoteAddress?.replace("::ffff:", "") || "unknown";

  const now = new Date().toISOString();
  const luckyNumber = Math.floor(Math.random() * 100) + 1;

  console.log(
    `[${now}] ${req.method} ${req.url} from ${clientIp}`
  );

  res.statusCode = 200;
  res.setHeader("Content-Type", "text/plain; charset=utf-8");

  if (req.url === "/") {
    res.end(
      `Pozdravljen!\n` +
      `Tvoj IP: ${clientIp}\n` +
      `Tvoj srečni Docker številki sta danes: ${luckyNumber}\n`
    );
  } else if (req.url === "/health") {
    res.end("OK");
  } else {
    res.statusCode = 404;
    res.end("Neznana pot\n");
  }
});

server.listen(PORT, () => {
  console.log(`Server is listening on port ${PORT}`);
});
