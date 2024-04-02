from http.server import SimpleHTTPRequestHandler, HTTPServer

PORT = 8000

handler = SimpleHTTPRequestHandler
httpd = HTTPServer(("", PORT), handler)

print("Serveur en cours d'exécution sur le port", PORT)
httpd.serve_forever()
