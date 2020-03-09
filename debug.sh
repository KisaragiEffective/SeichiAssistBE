#!/bin/bash
cd `dirname $0`
set -e

readonly JAR_NAME="SeichiAssistBE-1.0.0.jar"

sh ./gradlew build
mkdir -p ./srv/plugins && chmod 774 ./srv
cp -f ./build/libs/$JAR_NAME ./srv/plugins/

docker pull "ixilon/nukkit:1.14.0"
docker-compose up -d

if type "socat" > /dev/null 2>&1 && [ ! -f ./srv/nukkit.yml ]; then
  echo "set the language automatically"
  echo "jpn" | socat EXEC:"docker attach seichiassistbe_nukkit_1",pty STDIN
fi
