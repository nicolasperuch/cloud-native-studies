#!/bin/bash

echo "6/6= $(curl -s http://127.0.0.1:6001/math/div/6/6)"
echo "6*6= $(curl -s http://127.0.0.1:6002/math/mul/6/6)"
echo "6-6= $(curl -s http://127.0.0.1:6003/math/sub/6/6)"
echo "6+6= $(curl -s http://127.0.0.1:6004/math/sum/6/6)"
echo "2^10= $(curl -s http://127.0.0.1:6006/math/pow/2/10)"
echo "29x= $(curl -s http://localhost:6005/math/calc/29x)"
echo "ops= $(curl -s http://localhost:6005/math/ops/)"


#echo "Hystrix.stream: $(curl -s http://localhost:6005/metrics/hystrix.stream)"

