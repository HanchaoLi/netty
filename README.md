# netty framework practice

1. echo server implementation

    a). echo server in charge of recevie messge from client whether use telnet or echo client, 
    and send back same message to client.
    
    b). echo client simplely send message to echo server.

2. replicate TCP/IP pack, unpack problem: client sent 10 times message, but server only got one.

      * Solution: use LineBasedFrameDecoder and StringDecoder, check branch NT-004 for more detail
