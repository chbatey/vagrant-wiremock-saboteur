Vagrant VM with Wiremock and Saboteur
=====================================

Work in progress example of how to test network latecny and timeouts. The vagrant VM is complete, the cucumber tests are a WIP.

### Requirements
* Vagrant

### Starting the VM

```
cd ./vm
vagrant up
```

The first time will take some time.

The VM is assigned IP 192.168.2.2, if thie conflicts with anything on your network change Vagrantfile.

To see the URLs that the wiremock is mocking go to:

[Wiremock mappings](http://192.168.2.2:8080/__admin/)

You can see we have one endpoint on /name - [name](http://192.168.2.2:8080/name)

TODO:
Document the APIs for delaying traffic etc. The functional tests will use the Java library called crashlab.


