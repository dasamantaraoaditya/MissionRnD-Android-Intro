@echo on
echo "%1"
if "%1" == "" (
   echo dest dir needs to be specified
   exit /b

)

xcopy * %1 /S /I /Q /K
pushd "%1"
cd app\src\main\res
call replace.cmd "<!--STARTREPLACE-->[\s\S]*?<!--ENDREPLACE-->" "<!--Add your widgets here -->" layout -r
call replace.cmd "<!--STARTREPLACE-->[\s\S]*?<!--ENDREPLACE-->" "<!-- -->" values -r

cd ..\java\com\example
REM use *? to do shortest matching
call replace.cmd "//STARTREPLACE[\s\S]*?//ENDREPLACE" "//Put your code here" *
popd
