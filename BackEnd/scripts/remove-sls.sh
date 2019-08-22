#!/bin/bash
SLS_AWS_PROFILE=$1

echo "******************************************************************"
echo "Removing Serverless Infrastructure..."
cd ../sls

sls remove --aws-profile $SLS_AWS_PROFILE -v

echo "Serverless Infrastructure removed!"