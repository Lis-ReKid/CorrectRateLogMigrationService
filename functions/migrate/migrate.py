import logging
from typing import Dict, Any

import migration_service

logging.getLogger().setLevel(logging.INFO)


def handler(event: Dict[str, Any], context: Any) -> Dict[str, Any]:
    migration_data = migration_service.execute(event)

    # HTTPレスポンスを作成して返す。
    return {
        "statusCode": 200,
        "body": migration_data
    }
