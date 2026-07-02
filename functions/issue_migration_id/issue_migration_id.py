import logging
import migration_id_service

logging.getLogger().setLevel(logging.INFO)


def handler(event, context):
    migration_id_service.issue_migration_id()
