yum install -y java-1.7.0-openjdk.x86_64 lsof wget nc

# Set up and run WireMock
cp /vagrant/wiremock*.jar /home/vagrant/wiremock.jar
cp /vagrant/scassandra*.jar /home/vagrant/scassandra.jar
mkdir -p /home/vagrant/mappings
cp -r /vagrant/mappings/* /home/vagrant/mappings

cp /vagrant/*.sh /home/vagrant

chown vagrant:vagrant /home/vagrant/wiremock.jar

nohup java -jar wiremock.jar --port=8080 --verbose &

# Set up and run Saboteur
echo "installing saboteur ..."
rpm -ivh https://github.com/tomakehurst/saboteur/releases/download/v0.7/saboteur-0.7-1.noarch.rpm

echo "starting saboteur ..."
service saboteur-agent start

ifconfig eth1 mtu 100 up
