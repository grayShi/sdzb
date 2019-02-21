#/bin/bash
if [ -f "pid" ]
then 
  pid=`cat pid`
  if ps -p $pid > /dev/null
  then 
      echo "Stopping oa server."
      kill $pid
      rm -rf pid
  fi
fi
echo "Starting oa server."
nohup java -jar -Djava.security.egd=file:/dev/./urandom  -Dspring.profiles.active=prod ../backserver/target/webserver-1.0-SNAPSHOT.jar > run.log 2>&1 &
echo $! > pid