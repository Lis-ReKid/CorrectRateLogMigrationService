import logging

import boto3
import os

logger = logging.getLogger(__name__)

client = boto3.client('s3')


def save_migration_data(migration_id, body):
    extension = ".json"

    # ボディをJSONとしてS3に格納。
    client.put_object(
        Body=body,
        Bucket=os.environ["Bucket"],
        Key=os.environ["Key_prefix"] + migration_id + extension,
    )
