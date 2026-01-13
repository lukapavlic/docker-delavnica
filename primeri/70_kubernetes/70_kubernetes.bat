docker build -t=iideveloper21/meas25:latest .
docker push iideveloper21/meas25:latest

kubectl apply -f backend.yaml
kubectl get pods

kubectl logs -f deployment/backend

kubectl get svc backend-service

# EXTERNAL-IP:PORT

# kubectl delete -f backend.yaml


