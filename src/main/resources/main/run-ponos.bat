@echo off
echo.
echo.
echo # ----------------------------------------
echo #
echo # Running Ponos
echo #
echo # ----------------------------------------
echo.

java -cp ./lib/postgresql-42.3.6.jar;./lib/SparkJDBC42.jar;./ponos.jar org.nachc.cad.tools.ponos.main.PonosMain %1

echo.
echo.
echo Done.
echo.
echo.