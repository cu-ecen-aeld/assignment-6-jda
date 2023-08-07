#!/bin/sh

cd /lib/modules/*/extra

start() {
        /usr/sbin/scull_load
}

stop() {
        /usr/sbin/faulty_unload
}

case "$1" in
        start|stop)
                "$1";;
        *)
                echo "Usage: $0 {start|stop}"
                exit 1
esac