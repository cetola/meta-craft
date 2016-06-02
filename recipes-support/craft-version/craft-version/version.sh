#!/bin/sh

export TMPDIR=/mnt/.psplash

SN=$(cat /etc/craft-version  |grep "^meta-craft"|awk '{print $3}' | cut -c1-8)

if [ "$(rdev)" = "" ]; then
    SN=${SN}-NAND  
fi
                                                                              
/usr/bin/psplash-write "MSG $SN"
