# decrypt-hash

## Install

```bash
git -C /Disk1/decrypt-hash pull "https://$GIT_TOKEN@github.com/ON3-Solutions/decrypt-hash.git" || [ $? == 128 ] || { echo 'ERRO NO PULL DO GIT' && exit 1 ; }
export JAVA_HOME=/Disk1/jdks/jdk-16.0.1/
./mvnw clean compile assembly:single
```

## Running

```bash
nohup /Disk1/jdks/jdk-16.0.1/bin/java -jar target/decrypt-hash-0.0.1-SNAPSHOT-jar-with-dependencies.jar > ./decrypt-hash.log &
tail -f ./decrypt-hash.log
```
