# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit module

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignment-7-jda;protocol=ssh;branch=main"
SRC_URI += "file://Makefile.patch"

#PV = "1.0+git${SRCPV}"
SRCREV = "1cbb746ecc9cf54aa148a3fa7754bf76c0cfa31e"
S = "${WORKDIR}/git/misc-modules"

EXTRA_OEMAKE:append_task-install = " -C ${STAGING_KERNEL_DIR} M=${S}"

#KERNEL_MODULE_AUTOLOAD += "hello"
#KERNEL_MODULE_AUTOLOAD += "faulty"

RPROVIDES:${PN} += "kernel-module-misc-modules"
