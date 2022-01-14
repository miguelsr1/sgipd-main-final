#!/usr/bin/env bash
export APP_HOME=$(dirname $(realpath $0))

export INSTALL_OWNER=sgipd
export EXCEL_TEMPLATES="/deployments/exceltemplates"
export INSTALL_DIR="/deployments/wildfly-bootable"
export JAR_BOOTABLE="sgipd-web-bootable.jar"
export TEMPLATE_NAME="Informe_de_Inscritos_concurso_de_plazas_docentes_template.xlsx"

if [ ! -d "$INSTALL_DIR" ]
then
  mkdir -p $INSTALL_DIR
else
  echo "Directory $INSTALL_DIR already exists"
fi

if [ ! -d "$EXCEL_TEMPLATES" ]
then
  mkdir -p $EXCEL_TEMPLATES
else
  echo "Directory $EXCEL_TEMPLATES already exists"
fi


cp -rfv $APP_HOME/exceltemplates/$TEMPLATE_NAME  $EXCEL_TEMPLATES
cp -rfv $APP_HOME/target/${JAR_BOOTABLE} $INSTALL_DIR/wildfly-bootable.jar
