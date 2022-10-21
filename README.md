# Redis-Labs

Welcome Here is a small Redis Applcation and a Quick Start Guide to Redis 
![Redis](https://myoctocat.com/assets/images/base-octocat.svg)


To configure Redis to accept remote connections open the Redis configuration file with your text editor:

sudo nano /etc/redis/redis.conf
Copy
Locate the line that begins with bind 127.0.0.1 ::1 and replace 127.0.0.1 with 0.0.0.0.

/etc/redis/redis.conf
# IF YOU ARE SURE YOU WANT YOUR INSTANCE TO LISTEN TO ALL THE INTERFACES
# JUST COMMENT THE FOLLOWING LINE.
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
bind 0.0.0.0 ::1
Copy
Save the file and close the editor.

Restart the Redis service for changes to take effect:

sudo systemctl restart redis-server
Copy
Use the following command to verify that redis is listening on all interfaces on port 6379:

ss -an | grep 6379
Copy
You should see something like below. 0.0.0.0 means all IPv4 addresses on the machine.

tcp  LISTEN 0   128   0.0.0.0:6379   0.0.0.0:*
tcp  LISTEN 0   128      [::]:6379      [::]:*  
Copy
Next, you’ll need to add a firewall rule that enables traffic from your remote machines on TCP port 6379.

Assuming you are using UFW to manage your firewall and you want to allow access from the 192.168.121.0/24 subnet you would run the following command:

sudo ufw allow proto tcp from 192.168.121.0/24 to any port 6379
Copy
At this point, Redis server will accept remote connections on TCP port 6379.

Make sure your firewall is configured to accept connections only from trusted IP ranges.

To verify that everything is set up properly, you can try to ping the Redis server from your remote machine using the redis-cli utility:

redis-cli -h <REDIS_IP_ADDRESS> ping
Copy
The command should return a response of PONG:

PONG
