__author__ = 'hshao'
import boto
import boto.s3.connection
import argparse
parser = argparse.ArgumentParser(description='Use send reg mail for apollo')

parser.add_argument('-a', '--accesskey', required=True, default=None, dest='access_key',
            help='access_key')
parser.add_argument('-s', '--secretkey', required=True, default=None, dest='secret_key',
            help='secret_key')
parser.add_argument('-b', '--bucketname', required=True, default=None, dest='bucket_name',
            help='bucket_name')


args = parser.parse_args()

# access_key = '5VGOC2Q6JB1SSM6DOEVW'
# secret_key = 'llR69fBLGCQRBeDDxcgTTuJJOqnJyePxFc3g3Ctl'
# bucket_name = 'hshao002'

access_key = args.access_key
secret_key = args.secret_key
bucket_name = args.bucket_name

conn = boto.connect_s3(
    aws_access_key_id = access_key,
    aws_secret_access_key = secret_key,
    host = 'adminnode',
    is_secure=False,
    calling_format = boto.s3.connection.OrdinaryCallingFormat(),
)

is_suc = False
try:
    bucket = conn.create_bucket(bucket_name)
    is_suc = True
except:
    pass

if is_suc:
    exit(0)
else:
    exit(1)