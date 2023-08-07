#!/bin/sh

cd /lib/modules/*/extra

start() {
        /usr/sbin/misc_module_load faulty
        modprobe hello
}

stop() {
        rmmod hello
        /usr/sbin/misc_module_unload faulty
}

case "$1" in
        start|stop)
                "$1";;
        *)
                echo "Usage: $0 {start|stop}"
                exit 1
esac