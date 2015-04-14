import socket               # Import socket module

s = socket.socket()         # Create a socket object
host = '192.168.42.1' #socket.gethostname() # Get local machine name
port = 9999                 # Reserve a port for your service.

print host
s.connect((host, port))
f = open('Image.svg','rb')
print 'Sending...'
l = f.read(1024)
while (l):
    s.sendall(l)
    l = f.read(1024)
f.close()
print "Done Sending"
s.close()
