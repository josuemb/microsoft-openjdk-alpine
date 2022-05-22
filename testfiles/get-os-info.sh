#!/bin/bash
cat /etc/os-release | sed 's|"||g' | awk -F '=' 'BEGIN{print "["} NR>1 {print ","} {print "\""$1"\""":""\""$2"\""} END{print "]"}' | paste -d "\0" -s