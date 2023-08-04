DESCRIPTION = "scripts to support aesd modules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignment-7-jda;protocol=ssh;branch=main"

#PV = "1.0+git${SRCPV}"
SRCREV = "1cbb746ecc9cf54aa148a3fa7754bf76c0cfa31e"
S = "${WORKDIR}/git/misc-modules"

do_install() {
  install -d ${D}${sbindir}
  install -m 0755 ${S}/module_load ${D}${sbindir}/misc_module_load
  install -m 0755 ${S}/module_unload ${D}${sbindir}/misc_module_unload
}
FILES:${PN} += "${sbindir}/misc_module_load"
FILES:${PN} += "${sbindir}/misc_module_unload"

RDEPENDS:${PN} += "kernel-module-misc-modules"

