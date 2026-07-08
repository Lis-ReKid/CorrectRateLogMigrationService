import logging
from typing import Dict, Any

import migration_data_repository

logger = logging.getLogger(__name__)


def execute(event: Dict[str, Any]) -> str:
    # ハンドラ開始をログ出力。
    logger.info("Start handler()")

    # クエリパラメータを取得
    migration_id: str = event["pathParameters"]["id"]

    # 移行データを取得
    migration_data = migration_data_repository.get_migration_data(migration_id)

    return migration_data
