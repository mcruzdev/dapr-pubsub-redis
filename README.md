# dapr-pubsub

If you want to use directly my docker images, jump to the step [four](#4-create-kind-cluster).

### 1. Packaging pub application

```sh
    cd pub
    ./gradlew clean build
    docker build . --tag=matheuscruzdev/pub:0.1.0  
    cd ..      
```

### 2. Packaging sub application
```sh
    cd sub
    ./gradlew clean build
    docker build . --tag=matheuscruzdev/sub:0.1.0
    cd ..
```

### 3. Publish docker images

```sh
    docker push matheuscruzdev/pub:0.1.0
    docker push matheuscruzdev/sub:0.1.0
```

### 4. Create kind cluster
```sh
    kind create cluster dapr
```

### 5. Add dapr and redis

```shell

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
    --wait
```

### 6. Apply dapr component

```sh
    kubectl apply --filename redis-dapr.yaml
```

### 7. Add apps

```sh
    kubectl apply -f pub/k8s/resources.yaml
    kubectl apply -f sub/k8s/resources.yaml
```

### 8. Add dapr-ambient for each apps

```sh
    helm install sub-ambient . --set ambient.appId=pub --set ambient.proxy.remoteURL=pub:8080 
    helm install pub-ambient . --set ambient.appId=sub --set ambient.proxy.remoteURL=sub:8080
```