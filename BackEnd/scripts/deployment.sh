#!/bin/bash
DEPLOYMENT_ENV=$1
TABLE_NAME=$2
LAMBDA_USER=$3
LAMBDA_PWD=$4
PACKAGE_NAME=$5
SLS_AWS_PROFILE=$6

echo "******************************************************************"
echo "Retrieving DynamoDB Table ARN..."
if [ -z "$SLS_AWS_PROFILE" ]
then
    table_arn=$(aws dynamodb describe-table --table-name $TABLE_NAME --query Table.TableArn)
else
    echo 'AWS Profile Provided:' $SLS_AWS_PROFILE
    table_arn=$(aws dynamodb describe-table --table-name $TABLE_NAME --query Table.TableArn --profile $SLS_AWS_PROFILE )
fi

if [ -z "$table_arn" ]
then
   echo -en "\e[1m\e[91mFailed to locate DynamoDB table, terminating.\e[0m\n"
   exit 1
else
   echo 'Table ARN:' $table_arn
fi

IFS='/' read -a array1 <<< "${table_arn}" # Remove string after ' / '
IFS='"' read -a array2 <<< "${array1[0]}" # Remove string before ' " '
dynamodb_arn_table=${array2[1]}
echo 'DynamoDB ARN Table:' $dynamodb_arn_table

echo "******************************************************************"
echo "------- Serverless Framework ----------"
cd ../sls

if [ -z "$PACKAGE_NAME" ]
then
    package=$(ls ../target/SuggestionBox-1.0.jar)    
    echo 'Package found:' $package
else
    package=$(ls $PACKAGE_NAME)
    echo 'Package provided:' $package
fi

#echo "------- Installing documentation plugin..."
#sls plugin install -n "serverless-aws-documentation"
#echo "------- Installing npm Warmup plugnins..."
#npm install -n "serverless-plugin-lambda-warmup"


echo "------- Deploying Serverless..."
if [ -z "$SLS_AWS_PROFILE" ]
then
    sls deploy --dynamodb-arn-table $dynamodb_arn_table --package-name $package --stage $DEPLOYMENT_ENV --user $LAMBDA_USER --pass $LAMBDA_PWD
else
    echo 'AWS Profile Provided:' $SLS_AWS_PROFILE
    sls deploy --aws-profile $SLS_AWS_PROFILE -v --dynamodb-arn-table $dynamodb_arn_table --package-name $package --stage $DEPLOYMENT_ENV 
fi

