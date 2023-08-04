# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignment-7-jda;protocol=ssh;branch=main"

#PV = "1.0+git${SRCPV}"
SRCREV = "1cbb746ecc9cf54aa148a3fa7754bf76c0cfa31e"
S = "${WORKDIR}/git/scull"

do_install() {
  install -d ${D}${sbindir}
  install -m 0755 ${S}/scull_load ${D}${sbindir}
  install -m 0755 ${S}/scull_unload ${D}${sbindir}
}
FILES:${PN} += "${sbindir}/scull_load"
FILES:${PN} += "${sbindir}/scull_unload"

RDEPENDS:${PN} += "kernel-module-scull"
