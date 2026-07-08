import logging
from typing import Dict, Any

logger = logging.getLogger(__name__)


def execute(event: Dict[str, Any]) -> str:
    # ハンドラ開始をログ出力。
    logger.info("Start handler()")

    # クエリパラメータのIDをログ出力。
    logger.info(event)
    logger.info(event["pathParameters"]["id"])
