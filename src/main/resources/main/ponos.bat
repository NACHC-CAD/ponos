@echo off
echo.
echo.
echo # ----------------------------------------
echo #
echo # Running Ponos
echo #
echo # ----------------------------------------
echo.

set workingDir=%CD%

echo Working Directory: %workingDir%

java -jar -Dosgi.requiredJavaVersion=1.8 -Dosgi.instance.area.default=@user.home/eclipse-workspace -XX:+UseG1GC -XX:+UseStringDeduplication -Dosgi.requiredJavaVersion=11 -Dosgi.dataAreaRequiresExplicitInit=true -Xms1g -Xmx16g ponos.jar %1  

echo.
echo.
echo Done.
echo.
echo.