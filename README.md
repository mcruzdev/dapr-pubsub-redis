# dapr-pubsub

```shell
kubectl create namespace production

helm repo add dapr \
    https://dapr.github.io/helm-charts

helm repo update

helm upgrade --install \
    dapr dapr/dapr \
    --namespace dapr-system \
    --create-namespace \
    --wait

helm repo add bitnami \
    https://charts.bitnami.com/bitnami

helm repo update

helm upgrade --install \
    redis bitnami/redis \
    --namespace production \
    --create-namespace \
    --wait

kubectl --namespace production apply \
    --filename redis-dapr.yaml
```