import logging

import migration_id_service

logging.getLogger().setLevel(logging.INFO)


def handler(event, context):
    migration_id = migration_id_service.execute()
    return {
        "statusCode": 200,
        "body": migration_id,
    }
