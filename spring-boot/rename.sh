#!/bin/bash
currentName="spring-boot"
newName=$1

# rename every occurency in files (like *.MD, pom.xml, etc.)
grep -rli "$currentName" * | xargs -i@ sed -i "s/$currentName/$newName/g" @

# rename mvn moduls
for file in "$currentName"*
do
  mv "$file" "$newName-${file##*-}"
done

# rename current folder
mv "$PWD" "${PWD%/*}/$newName"

# change into new folder
cd .. && cd ./"$newName"
