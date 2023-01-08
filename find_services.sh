curl -u s283945:123 \
       -H 'Content-Type: application/json' \
       -d '{
             "address": "127.0.0.1",
             "port": 8500,
             "enabled": true,
             "retry_timeout": 10
           }' http://127.0.0.1:5555/v2/service_discovery/consul