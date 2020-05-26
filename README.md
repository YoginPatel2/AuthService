# AuthService

API: Authenticate

curl -X POST \
  http://localhost:8080/authenticate \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 4e56429c-db44-11f7-1959-1a0c2e2428c7' \
  -d '{
	"username":"yogin",
	"password":"patel"
}'

API: Validate Token

curl -X GET \
  http://localhost:8080/validate \
  -H 'authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5b2dpbiIsImV4cCI6MTU5MDQ5NjcwMSwiaWF0IjoxNTkwNDk2NjcxfQ.I6rRa-xeaWiN0OZ41_zTNcCY5p9_5tQlFcuN76lO3Yc-ccBo7i0BgWfEudFgQK_jjpDOx2I2DtgqaAcaZigmOw' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: e6715760-b893-abb9-b70d-46c8d0ca4b4e'

