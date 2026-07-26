import logging

import boto3
import os

logger = logging.getLogger(__name__)

client = boto3.client('s3')


def get_migration_data(id: str) -> str:
    logger.info('Start getting migration data.')

    extention: str = '.json'

    s3_object: dict = client.get_object(
        Bucket=os.environ['Bucket'],
        Key=os.environ['Key_prefix'] + id + extention
    )
    migration_data_str = s3_object['Body'].read().decode("utf-8")

    return migration_data_str
