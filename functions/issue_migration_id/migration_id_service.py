import logging
import random
import migration_data_repository


logger = logging.getLogger(__name__)


def execute(event):
    logger.info('Start issue migration id.')

    # リクエストボディを取得する。
    body = event["body"]

    # 移行IDを取得。
    migration_id = get_migration_id()

    # ボディをJSONとしてS3に格納。
    migration_data_repository.save_migration_data(migration_id, body)
    logger.info('Stored migration data.')

    # 移行IDを返却
    logger.info('migration ID issued.')
    return migration_id


def get_migration_id():
    # 文字セットの中からサイズ8のランダム文字列を返す。
    allowed_chars = "abcdefghijkmnopqrstuvwxyz123456789"
    return "".join(random.choices(allowed_chars, k=8))
