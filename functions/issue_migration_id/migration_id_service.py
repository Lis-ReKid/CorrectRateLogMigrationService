import logging
import random

logger = logging.getLogger(__name__)


def execute():
    logger.info('Start issue migration id.')

    # 移行IDを返却
    logger.info('migration ID issued.')
    return get_migration_id()


def get_migration_id():
    # 文字セットの中からサイズ8のランダム文字列を返す。
    allowed_chars = "abcdefghijkmnopqrstuvwxyz123456789"
    return "".join(random.choices(allowed_chars, k=8))
