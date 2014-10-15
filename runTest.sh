cd vm
vagrant up

cd ..
java -jar server.jar server properties.yml &

SERVER_ID=$?

mvn test
kill -9 $SERVER_ID

cd vm
vagrant destroy --force
