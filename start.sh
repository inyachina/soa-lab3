consul agent -server -bootstrap-expect=1 -data-dir=data/consul_data -ui -bind=127.0.0.1 > log/consul.log &
java -jar ~/main_service/soa1.jar > ~/log/main_service1.log &
java -jar ~/main_service/soa2.jar > ~/log/main_service2.log &
sudo systemctl restart haproxy
