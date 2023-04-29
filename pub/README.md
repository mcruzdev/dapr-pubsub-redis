```shell
curl --request POST \
  --url http://localhost:8080/specs \
  --header 'Content-Type: application/json' \
  --data '{
	"version": "0.1.0-alpha",
	"url": "http://localhost:8080/ping",
	"stages": [
		{
			"target": 10,
			"duration": 10
		},
		{
			"target": 20,
			"duration": 10
		},
		{
			"target": 10,
			"duration": 10
		}
	]
}'
```