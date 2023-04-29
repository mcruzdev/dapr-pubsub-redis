# dapr-pubsub


### 1. Packaging pub application

```sh
    cd pub
    ./gradlew clean build
    docker build . --tag=USERNAME_HERE/pub:0.1.0  
    cd ..      
```

### 2. Packaging sub application
```sh
    cd sub
    ./gradlew clean build
    docker build . --tag=USERNAME_HERE/sub:0.1.0
    cd ..
```

### 3. Publish docker images

```sh
    docker push USERNAME_HERE/pub:0.1.0
    docker push USERNAME_HERE/sub:0.1.0
```

### 4. Package helm chart

```sh
    helm package pub/chart/
    helm package sub/chart/
```

### 5. Create kind cluster
```sh
    kind create cluster dapr
```

### 6. Add dapr and redis

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

### 7. Apply dapr component

```sh
    kubectl apply --filename dapr-component.yaml
```
