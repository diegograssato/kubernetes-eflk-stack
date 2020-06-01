# Kuberntes EF(L)K Stack

Fully fucntional centralized logging for microservices applications hosted on Kubernetes.

https://pw999.wordpress.com/2017/05/12/adding-filebeat-to-docker-images/

docker run \
 --log-driver=syslog \
 --log-opt syslog-address=tcp://172.17.0.3:5044 \
 --log-opt syslog-facility=daemon \
  alpine ash


# Ingress basic auth

```
htpasswd -c auth foo
New password: <bar>
New password:
Re-type new password:
Adding password for user foo

```

```
 kubectl create secret generic basic-auth --from-file=auth -n elastic-logging
 rm auth

 kubectl -n elastic-logging get secret basic-auth -o yaml
```

```
echo "
apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: ingress-with-auth
  annotations:
    # type of authentication
    nginx.ingress.kubernetes.io/auth-type: basic
    # name of the secret that contains the user/password definitions
    nginx.ingress.kubernetes.io/auth-secret: basic-auth
    # message to display with an appropriate context why the authentication is required
    nginx.ingress.kubernetes.io/auth-realm: 'Authentication Required - foo'

```



<img src="https://raw.githubusercontent.com/srinisbook/images/master/efk-stack.png"
     alt="Prometheus and Grafana Architecture"
     style="float: left; margin-right: 10px;" />

```
 
